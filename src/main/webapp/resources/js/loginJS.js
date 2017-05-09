/**
 * Created by Admin on 28.04.2017.
 */
$("#username").mouseenter(function () {
    $("#username").css({'background-color':'#f589df'})
});
$("#username").mouseleave(function () {
    $("#username").css({'background-color':'white'})
});

$("#logIn").mouseenter(function () {
    $("#logIn").css({'background-color':'#ca3eb0','border':'solid 1px white','font-size':'x-large'})
});
$("#logIn").mouseleave(function () {
    $("#logIn").css({'background-color':'#f589df','border':'none','font-size':'large'})
});

$("#password").mouseenter(function () {
    $("#password").css({'background-color':'#f589df'})
});
$("#password").mouseleave(function () {
    $("#password").css({'background-color':'white'})
});

$("#register").mouseenter(function () {
    $("span").css({'font-size':'x-large','color':'white'})
});
$("#register").mouseleave(function () {
    $("span").css({'font-size':'medium','color':'dimgrey'})
});


$("span").click(function () {
    $(".login").fadeOut(500)
    $(".registerForm").fadeIn(500)
});

$("#registerButton").mouseenter(function () {
    $("#registerButton").css({'background-color':'#ca3eb0','border':'solid 1px white','font-size':'x-large'})
});
$("#registerButton").mouseleave(function () {
    $("#registerButton").css({'background-color':'#f589df','border':'none','font-size':'large'})
});
$("#singIn").mouseenter(function () {
    $("#singIn").css({'font-size':'x-large','color':'white'})
});
$("#singIn").mouseleave(function () {
    $("#singIn").css({'font-size':'medium','color':'dimgrey'})
});
$("#singIn").click(function () {
    $(".registerForm").fadeOut(500);
    $(".login").fadeIn(500)
});
function getObject() {
    return {name: $("#firstName").val(), secondName: $("#secondName").val(), email: $("#email").val(), phone: $("#phone").val(), password: $("#passwordUser").val(),login:$("#loginUser").val()};
}
$("#registerButton").click(function () {
    if(validate(getObject())) {
        $.ajax({
            url: '/users/add',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(getObject()),
            success: function () {
                resetForm();
                $(".registerForm").fadeOut(500);
                $(".login").fadeIn(500)
            }
        });
    }
});
function resetForm() {
    $("#firstName").val("");
    $("#secondName").val("");
    $("#email").val("");
    $("#phone").val("");
    $("#passwordUser").val("");
    $("#loginUser").val("");
    $("#errorMessages").css({'display':'none'});
}
function showErrorMessage(message) {
    $("#errorMessages").css({'display':'block'});
    $("#errorMessages").text(message);
}
function validate(object) {
    var firstNameAndLastNameRegex = /[a-zA-Z\-]/;
    var emailRegex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  if(object.name== ""|| !object.name.match(firstNameAndLastNameRegex)){
showErrorMessage("Invalid Name");
return false;
  }
  if(object.secondName== ""||!object.secondName.match(firstNameAndLastNameRegex)){
      showErrorMessage("Invalid Second Name");
      return false;
  }
    if(object.email == "" || !object.email.match(emailRegex)){
        showErrorMessage("Error in email!");
        return false;
    }
    if(object.phone == ""){
        showErrorMessage("Error in phone!");
        return false;
    }
    if(object.password == ""){
        showErrorMessage("Error in password!");
        return false;
    }
    return true;
}