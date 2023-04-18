


function createProductCards() {
    let productArray = productService.getProducts();
    const productCardsArea = document.getElementById("product-cards");
    console.log(productCardsArea);
    productArray.forEach((element, index) => {

        //Creates the product card, then appends it to a list of all existing product cards
        let oneProductCard = document.querySelector('.hidden').cloneNode(true);
        productCardsArea.appendChild(oneProductCard);
        let allExistingProductCards = productCardsArea.querySelectorAll('.product-card');
        let currentProductCard = allExistingProductCards[index];

        let productCardChildren = currentProductCard.children;
        currentProductCard.classList.remove('hidden');
        productCardChildren[0].textContent = element.productSku;
        productCardChildren[1].textContent = element.price;
        productCardChildren[2].textContent = element.name;
        productCardChildren[3].querySelector('img').src = element.imageName;

    })
    // for(let i = 0; i < productArray.length; i++){

    //     productCardsArea.appendChild(newElement);
    // }
  }
  
  window.addEventListener('load', () => {
    createProductCards();
  });
    //   <article class="product-card hidden" >
    //     <div class="sku"></div>
    //     <div class="price"></div>
    //     <div class="product-name action" data-id="1"></div>
    //     <div class="product-image">
    //       <img src="https://via.placeholder.com/350x250.jpg">
    //     </div>
    //     <div class="cart">
    //       <i class="fa-solid fa-cart-plus icon action" title="Add item to cart"></i>
    //     </div> 
    //   </article>
