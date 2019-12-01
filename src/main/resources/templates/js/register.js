$(document).ready(function(){
    
});

$( "#cep").blur(function() {
    var urlCep = $('#cep').val();
    var action = 'https://viacep.com.br/ws/'+urlCep+'/json/';
    $.ajax({
        url: action,
        type: 'GET',
        success: (response) => {
            writeFields(response);
        },
        error: (errors) => {
            alert('Erro ao buscar endereços pelo Cep, verifique sua conexão')
        }
      })
  });

function writeFields(response) {
    $('#logradouro').val(response.logradouro)
    $('#cidade').val(response.localidade)
    $('#estado').val(response.uf)
}