package br.unisul.minha.ProjetoWeb.service;

import br.unisul.minha.ProjetoWeb.model.Product;
import br.unisul.minha.ProjetoWeb.model.Shopping;
import br.unisul.minha.ProjetoWeb.model.User;
import br.unisul.minha.ProjetoWeb.repositories.IProductRepository;
import br.unisul.minha.ProjetoWeb.repositories.IShoppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ShoppingService {

    @Autowired
    private IShoppingRepository shoppingRepository;

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private UserService userService;

    public String save(Object jsonShoppings) {
        Map jsonMap = (Map) jsonShoppings;
        List<Shopping> shoppings = parser(jsonMap);
        String validate = validate(shoppings);
        if(!shoppings.isEmpty()) {
            shoppingRepository.saveAll(shoppings);
            for (Shopping shopping : shoppings) {
                productRepository.save(shopping.getProduct());
            }
        }
        return validate;
    }

    private List<Shopping> parser(Map jsonMap) {
        List<Shopping> shoppings = null;
        try {
            List<Map> shopDto = (ArrayList<Map>) jsonMap.get("shopDto");
            shoppings = new ArrayList<>();
            for (Map shop : shopDto) {
                if(((Integer) shop.getOrDefault("quantity", 0)) > 0 ) {
                    Shopping shopping = createShopping(shop);
                    shoppings.add(shopping);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shoppings;
    }

    private Shopping createShopping(Map shop) {
        Optional<Product> product = productRepository.findById((Integer) shop.get("userId"));
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = null;
        if (principal instanceof UserDetails) {
            String login = ((UserDetails)principal).getUsername();
            user = userService.findByLogin(login);
        }
        Shopping shopping = new Shopping();
        shopping.setProduct(product.get());
        shopping.setQuantity((Integer) shop.get("quantity"));
        shopping.setUser(user);
        shopping.setShoppingDate(LocalDateTime.now());
        return shopping;
    }

    public String validate(List<Shopping> shoppings) {
        String validate = "";
        List<Shopping> invalidShopping = new ArrayList<>();
        for (Shopping shopping: shoppings) {
            if(shopping.getQuantity() > shopping.getProduct().getQuantityAvailable()) {
                invalidShopping.add(shopping);
                validate += "Quantidade invalida de " + shopping.getProduct().getName();
            }else{
                Product product = shopping.getProduct();
                product.setQuantityAvailable(product.getQuantityAvailable() - shopping.getQuantity());
            }
        }
        shoppings.removeAll(invalidShopping);
        return validate;
    }

    public List<Shopping> findAll() {
        List<Shopping> shoppings = shoppingRepository.findAll();
        shoppings.parallelStream().forEach(shopping -> shopping.calcShoppingValue());
        return shoppings;
    }
}
