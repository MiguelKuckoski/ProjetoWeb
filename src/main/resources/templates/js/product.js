
function clearFields(){
    $('.quantity').val("0");
};

$("[type='number']").keypress(function (evt) {
    evt.preventDefault();
});

function save(){

    var action = '/shopping';
    var dataObject = {"shopDto":
    [{
    "userId":1,
    "productId":1,
    "quantity":1
    },
    {
    "userId":2,
    "productId":2,
    "quantity":2
    }]
    };
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