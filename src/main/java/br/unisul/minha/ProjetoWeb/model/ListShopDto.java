package br.unisul.minha.ProjetoWeb.model;

import java.util.ArrayList;
import java.util.List;

public class ListShopDto {

	private List<ShopDto> listShopDtos = new ArrayList<ShopDto>();

	public ListShopDto() {

	}

	public void addShopDto(ShopDto shopDto) {
		this.listShopDtos.add(shopDto);
	}

	public List<ShopDto> getListShopDtos() {
		return listShopDtos;
	}

	public void setListShopDtos(List<ShopDto> listShopDtos) {
		this.listShopDtos = listShopDtos;
	}

}
