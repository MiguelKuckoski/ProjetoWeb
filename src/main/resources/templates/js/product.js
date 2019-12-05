
function clearFields(){
    $('.quantity').val("0");
};

$("[type='number']").keypress(function (evt) {
    evt.preventDefault();
});

function save(){
    var action = '/shopping';
    var dataObject = [];

    $("tbody > tr").each(function(index, value) {
        let product = $("#product" + index).val();
        let quantity = $("#quantity" + index).val();
        let object = {"productId": product, "quantity": quantity};
        dataObject.push({"productId": product, "quantity": quantity});
    })

    var jsonObject = JSON.stringify(dataObject);
    $.ajax({
        url: action,
        type: 'POST',
        contentType: 'application/json',
        data: jsonObject,
        statusCode:{
            201: function(responseObject, textStatus, jqXHR) {
                console.log("CRIADOO");
                location.reload();
            }
        }
      })

}