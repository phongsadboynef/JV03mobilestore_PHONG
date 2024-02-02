$(document).ready(function(){
    $.ajax({
        url: "http://localhost:9191/mobilestore/related/list", // đường dẫn này là của cái API mình gọi trên postman muốn show ra bên ngoài
        method: "get",
    }).done(function(result){
        var listProduct =  result.data
        for(i=0; i<listProduct.length; i++){
            //String literal
            html += `<div class="col-md-F3 col-xs-6">
            <div class="product">
                <div class="product-img">
                    <img src="images/product01.png" alt="">
                    <div class="product-label">
                        <span class="sale">-30%</span>
                    </div>
                </div>
                <div class="product-body">
                    <p class="product-category">Category</p>
                    <h3 class="product-name"><a href="#">product name goes here</a></h3>
                    <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>
                    <div class="product-rating">
                    </div>
                    <div class="product-btns">
                        <button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>
                        <button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button>
                        <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
                    </div>
                </div>
                <div class="add-to-cart">
                    <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
                </div>
            </div>
        </div>`
            console.log('kiem tra',listProduct[i] )

        }
        $('#container-relatedproduct').append(html)
        

    })
});