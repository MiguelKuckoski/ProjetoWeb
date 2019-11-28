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
