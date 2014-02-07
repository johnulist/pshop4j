pshop4j
=======

PShop4j (Prestashop for java) is a library used as a wrapper to PrestaShop web services.  You will need only a PrestaShop online store with access to back office enabled and an authentication key.

Note: until now, only get requests are supported

How to use it?
--------------

Simply create a PrestaShopWebService object, just like that:

```java
public class PrestaShopTest{ 
    private String storeURL = "YOUR STORE URL";  // url to the store root (for example http://www.myPShop4JStore.com)
    private String accessKey = "YOUR AUTHENTICATION KEY";
    PrestaShopWebservice webservice;
    
    public PrestaShopTest(){
        webservice = new PrestaShopWebservice(storeURL, accessKey);
    }
}
```

In order to get access to the resources (i.e. products), we have two options.

The first option is a low level access.  Low level access returns an InputStream with the XML obtained the web service, without processing it in any way.

To use that, simply create a GetRequest object:


```java
public class PrestaShopTest{ 
    private String storeURL = "YOUR STORE URL";  // url to the store root (for example http://www.myPShop4JStore.com)
    private String accessKey = "YOUR AUTHENTICATION KEY";
    PrestaShopWebservice webservice;
    
    public PrestaShopTest(){
        webservice = new PrestaShopWebservice(storeURL, accessKey);
    }
    
    public InputStream getProducts(){
        GetRequest productsRequest = new GetRequest().withResource(Resources.products);
        try{
            PrestaShopResponse productsResponse = webservice.executeRequest(productsRequest);
            return productsResponse.getStream();
        }catch(ConnectException cnnEx){
            ...
        }catch(IOException ioEx){
            ...
        }
        return null;
    }
}
```





  

