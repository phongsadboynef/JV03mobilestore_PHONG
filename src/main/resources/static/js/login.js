// Khi nội dung file html đã được hiển thị trên browser thì sẽ kích hoạt
$(document).ready(function(){
    
    // Đăng ký sự kiện click cho thẻ tag được chỉ định bên HTML
    $("#btn-sign-in").click(function(){
        // .val() : Lấy giá trị của thẻ input được chỉ định
        var email = $("#email").val()
        var password = $("#pass").val()

        // Xuất giá trị ra trên tab console trên trình duyệt
        console.log("email : ",email, " password : ",password);

        //ajax : Dùng để call ngầm API mà không cần trình duyệt
        //axios, fetch
        //data : chỉ có khi tham số truyền ngầm
        $.ajax({
            url: "http://localhost:9191/mobilestore/login/signin",
            method: "post",
            data: {
                email: email,
                password: password
            }
        }).done(function(data){
            console.log("server tra ve ", data);
            window.location.href = "/mobilestore/";
        })
    });

    $("#btn-sign-up").click(function(){
        var email = $("#emailSignUp").val()
        var password = $("#passSignUp").val()

        console.log("email : ",email, " password : ",password);

        $.ajax({
            url: "http://localhost:9191/mobilestore/login/signup",
            method: "post",
            contentType: "application/json; charset=utf-8",
            dataType   : "json",
            data: JSON.stringify({
                email: email,
                password: password
            })
        }).done(function(data){
            console.log("server tra ve ", data);
            alert("Đăng ký thành công");
            window.location.href = "/mobilestore/";
        })
    });
})