pshop4j
=======

PShop4j (Prestashop for java) is a library used as a wrapper to PrestaShop web services.  You will need only a PrestaShop online store with access to back office enabled and an authentication key.

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



  

