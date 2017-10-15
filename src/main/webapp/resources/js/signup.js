function validatePassword() {
    const password1 = $('#password1');
    const password2 = $('#password2');

    if (password1.val() !== password2.val()) {
        password1.addClass('alert-danger');
        password2.addClass('alert-danger');
    } else {
        password1.removeClass('alert-danger');
        password2.removeClass('alert-danger');
    }
}

function validateEmail() {
    const email = $('#email');
    const emailRegex = new RegExp("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    if (!emailRegex.test(email.val())) {
        email.addClass('alert-danger');
    } else {
        email.removeClass('alert-danger');
    }
}

function validateText(e) {
    const text = $(e.currentTarget);
    const textRegex = new RegExp("^[a-zA-Zа-яА-Я0-9@.ЇїІіґҐ_]{5,32}$");
    if (!textRegex.test(text.val())) {
        text.addClass('alert-danger');
    } else {
        text.removeClass('alert-danger');
    }
}

$('#email').focusout((e) => {
    validateEmail();
});

$('#login').focusout((e) => {
    validateText(e);
});

$('.passwordCheck').focusout((e) => {
    const passwords = $('.passwordCheck');
    if (passwords[0] !== '' && passwords[1] !== '') {
        validatePassword();
    }
});

$('#submitForm').click((e) => {
    console.log(location.search);
    const form = $('#signup');
    const json = JSON.stringify({
        username: $('#login').val(),
        email: $('#email').val(),
        password: $('#password1').val(),
    });
    $.ajax({
        url: form.attr('action'),
        type: 'POST',
        data: json,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
    e.preventDefault(); //STOP default action
    // e.unbind(); //unbind. to stop multiple form submit.
});