<template>
    <article class="product-card" >
         <br>
        <div class="sku">{{product.productSku}}</div>
        <div class="price">{{product.price}}</div>
        <div class="product-name action" data-id="1">{{product.name}}</div>
        <div class="product-image">
            image
          <img src="">
        </div>
        <div class="cart">
          <i class="fa-solid fa-cart-plus icon action" title="Add item to cart"></i>
        </div> 
    </article>
</template>

<script>
export default {
    
    props: 
    {
        product: {},
    }

}


</script>

<style>

</style>