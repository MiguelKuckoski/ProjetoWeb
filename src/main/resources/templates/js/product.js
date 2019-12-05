
function clearFields(){
    $('.quantity').val("0");
};

$("[type='number']").keypress(function (evt) {
    evt.preventDefault();
});