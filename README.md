Duration : 2 hours
----------------------------------------------------------------
Develop a Product Catalog API using Spring Boot
----------------------------------------------------------------

ASSESSMENT Instructions:
- Project should use multilayered architecture with controller, service and DAO layers
- Appropriate status code and message should be sent in the responses for exceptional conditions
- Exception handling to be done using Global Exception Handler
- Use logging to log messages (At least in the Controller layer)
- Endpoints Should be accessible through Swagger  
- The whole project should be pushed to a Gitlab Repo named product_api_assessment


CREATE A NEW REPO IN GITLAB NAMED "product_api_assessment" and push the service in this  repo


** Create a Microservice ProductCatalogService to serve Product resource.
(Use MongoDb as Database)

    The Product resource should have the following properties
       productCode, productName, price, category,quantity 
       
    Create and expose the following endpoints
    
      * POST  /products 
      
        input Sample: {"productName": "keyboard", price": 5000, "category":"electronics", "quantity": 10}
      
        - To add a new Product along with the quantity
        - Should return the details of the new product added
        - success status code - 201
        -  Product with same name should not be added
        - price >0
              if the price <=0 throw the exception  InvalidPriceException
      
      GET /products/{productCode}
        - Search Product by product code
        - Should return the product details
        - For invalid productId , it  should throw an exception InvalidProdutCode  


      GET  /products/category/{category}/price/{price} 
        - search products by category and price limit given( all products of category within the given price)

*  GET  /products/category
   - search products by category and  return the products


* GET    /products
  - return all the products

*  GET  /products/price/{price}
   - return all the products  price is  greater than the given price

* Delete   /products/{productCode}
  - if the productCode  exist   remove  and send the appropriate
  response
  - if  not it should throw an exception InvalidProductCode
* put   /products/{productCode}
  - if the  productCode exist , update  the product information
  -  if  not it should throw an exception InvalidProductCode



     - Product with same name should not be added
     - Handle other exceptional conditions like product not found etc with appropriate response message and status 
 
 
