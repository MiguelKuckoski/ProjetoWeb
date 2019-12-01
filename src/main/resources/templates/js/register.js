$("#registerForm").submit(function(event){
    event.preventDefault();
    var post_url = $(this).attr("action");
    var request_method = $(this).attr("method");
    var form_data = $(this).serialize();

    $.ajax({
        url : post_url,
        type: request_method,
        data : form_data,
        timeout: 5000,
        success: function(data, textStatus ){
            alert('request successful');
        },
        fail: function(xhr, textStatus, errorThrown){
            alert('request failed');
        }
    })
});

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