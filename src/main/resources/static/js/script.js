document.getElementById("desctopSearch").addEventListener("focus", function() {
    var div = document.getElementById("myDropdown");
    div.style.display = "block";
    var a = div.getElementsByTagName("a");
    for (var i = 0; i < a.length; i++) {
        a[i].style.display = "block";
    }
});

document.getElementById("desctopSearch").addEventListener("focusout", function() {
    var div = document.getElementById("myDropdown");
    setTimeout(function() {
        div.style.display = "none";
        var a = div.getElementsByTagName("a");
        for (var i = 0; i < a.length; i++) {
            a[i].style.display = "none";
        }
    }, 300);
});

document.getElementById("mobileSearch").addEventListener("focus", function() {
    var div = document.getElementById("myDropdown");
    div.style.display = "block";
    var a = div.getElementsByTagName("a");
    for (var i = 0; i < a.length; i++) {
        a[i].style.display = "block";
    }
});

document.getElementById("mobileSearch").addEventListener("focusout", function() {
    var div = document.getElementById("myDropdown");
    setTimeout(function() {
        div.style.display = "none";
        var a = div.getElementsByTagName("a");
        for (var i = 0; i < a.length; i++) {
            a[i].style.display = "none";
        }
    }, 300);
});

function click(obj) {
    console.log("click");
    window.location.href(obj.parent.href);
}

function filterFunction(id) {
    var input, filter, a, i;
    var count = 0;
    input = document.getElementById(id);
    filter = input.value.toUpperCase();
    div = document.getElementById("myDropdown");
    a = div.getElementsByTagName("a");

    for (i = 0; i < a.length; i++) {
        txtValue = a[i].textContent || a[i].innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            a[i].style.display = "block";
            count++;
            console.log(count);
        } else {
            a[i].style.display = "none";
            count--;
            console.log(count);
        }
    }

    if(count<=0){
        console.log("last exit:"+count);
    }
}


    function sendCallBackRequest() {
        var contactPerson = $('#contactPersonName').val();
        var contactPhone = $('#contactPersonPhone').val();

        $.ajax({
            method: "post",
            url: "/sendCallback",
            contextType: "application/json",
            data: {
                contactPerson: contactPerson,
                contactPhone: contactPhone,
            },
            traditional: true,
            success: function () {
                $('#callBackModal').modal('hide');
                $('#thanksModal').modal('show');
            },
            error: function () {
                alert("Error");
            }
        });
    }