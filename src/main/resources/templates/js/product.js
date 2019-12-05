
function clearFields(){
    $('.quantity').val("0");
};

$('.quantity').blur(function(){
    if(!$(this).val()){
        $(this).val("0");
    }
})

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
        },
        error: function(){
            alert("Erro ao salvar, atualiza a página e tente novamente");
        }
      })
}

var modal = document.getElementById("myModal");

// Get the image and insert it inside the modal - use its "alt" text as a caption
var img = document.getElementById("myImg");
var modalImg = document.getElementById("img01");
var captionText = document.getElementById("caption");
img.onclick = function(){
  modal.style.display = "block";
  modalImg.src = this.src;
  captionText.innerHTML = this.alt;
}

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on <span> (x), close the modal
span.onclick = function() { 
  modal.style.display = "none";
}