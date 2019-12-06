$("#cep").blur(function () {
    var cep = $('#cep').val();
    if(cep){
        var action = 'https://viacep.com.br/ws/' + cep + '/json/';
        $.ajax({
            url: action,
            type: 'GET',
            success: (response) => {
                if(!response.erro){
                    writeFields(response);
                }
            },
            error: (errors) => {
                alert("Erro ao buscar endereços pelo Cep, verifique sua conexão");
            }
        })
    }
});

function writeFields(response) {
    $('#logradouro').val(response.logradouro)
    $('#cidade').val(response.localidade)
    $('#estado').val(response.ibge.substring(0,2))
}

function clearFields() {
    $('form :input').val('');
}

function idade(nascimento, hoje) {
    var diferencaAnos = hoje.getFullYear() - nascimento.getFullYear();
    if (new Date(hoje.getFullYear(), hoje.getMonth(), hoje.getDate()) <
        new Date(hoje.getFullYear(), nascimento.getMonth(), nascimento.getDate()))
        diferencaAnos--;
    return diferencaAnos;
}

$("#date").blur(function () {
    var nascimento = new Date($('#date').val());
    var hoje = new Date();
    var diferencaAnos = idade(nascimento, hoje);
    $("#idade").val(diferencaAnos);
    if (diferencaAnos > 120 || diferencaAnos < 5) {
        $("#btnCriarUsuario").attr("disabled", true);
        alert("Idade deve ser entre 5 e 105 anos");
    } else {
        $("#btnCriarUsuario").attr("disabled", false);
    }
});

$("#password").blur(function () {
    validPassword();
});

$("#confirmPassword").blur(function () {
    validPassword();
});

function validPassword() {
    var password = $("#password").val();
    var confirmPassword = $("#confirmPassword").val();
    if (password === confirmPassword) {
        $("#btnCriarUsuario").attr("disabled", false);
        $('#alertSenha').attr('hidden',true);
    } else {
        $("#btnCriarUsuario").attr("disabled", true);
        $('#alertSenha').attr('hidden',false);
    }
}