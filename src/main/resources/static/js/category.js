$(document).ready(function () {
    $('.close').click(function () {
        $('#popup').hide();
        clearForm()
    });

    $('#formCategory').validate({
        rules: {
            name: {
                required: true,
                minlength: 2,
                maxlength: 20
            },
            status: {
                required: true
            },
            showHomepage: {
                required: true
            }
        },
        messages: {
            name: {
                required: 'Please enter the name',
                minlength: 'Please enter at least 2 characters',
                maxlength: 'Please enter no more than 20 characters'
            },
            status: {
                required: 'Please select a status'
            },
            showHomepage: {
                required: 'Please select a show homepage'
            }
        },
        submitHandler: function (form) {
            let category = {
                'name': $('#name').val(),
                'status': $('#status').val(),
                'showHomepage': $('#showHomepage').val()
            }
            $.ajax({
                type: "POST",
                url: "api/v1/category",
                data: JSON.stringify(category),
                contentType: 'application/json',
                cache: false,
                success: function (response) {
                    showPopupSuccess('Success!', 'Add Product Success!');
                },
                error: function (xhr) {
                    showPopupError('Error!', xhr.responseJSON.message)
                }
            });
        }
    });

    function showPopupSuccess(title, message) {
        $('#popup .modal-header h2').text(title);
        $('#popup .modal-header h2').css({
            'color': 'green'
        })
        $('#popup .modal-body h3').text(message);
        $('#popup').show();
    };

    function showPopupError(title, message) {
        $('#popup .modal-header h2').text(title);
        $('#popup .modal-header h2').css({
            'color': 'red'
        })
        $('#popup .modal-body h3').text(message);
        $('#popup').show();
    };
    function clearForm() {
        $("#formCategory input")
            .not("#btnAddCategory").each(function () {
            $(this).val("");
        });
    }
})