/**
 * 
 */
package com.edgaragg.pshop4j.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.edgaragg.pshop4j.PrestaShopWebservice;
import com.edgaragg.pshop4j.model.Filter;
import com.edgaragg.pshop4j.model.GetRequest;
import com.edgaragg.pshop4j.model.Limit;
import com.edgaragg.pshop4j.model.PrestaShopRequest;
import com.edgaragg.pshop4j.model.Resources;
import com.edgaragg.pshop4j.model.Sort;
import com.edgaragg.pshop4j.modeling.PrestaShopMapper;
import com.edgaragg.pshop4j.modeling.PrestaShopMapperListener;
import com.edgaragg.pshop4j.pojos.entities.Customer;
import com.edgaragg.pshop4j.pojos.list.Associations;
import com.edgaragg.pshop4j.pojos.list.Customers;
import com.edgaragg.pshop4j.pojos.storedesc.StoreDescription;

/**
 * @author egonzalez
 * @param <Filters>
 *
 */
public class Pshop4jGet {

	@Test
	public void test() {
		PrestaShopWebservice web = new PrestaShopWebservice("192.168.1.139/prestashop", "0HMRPJPZM2CE10H1HLZH2HGXGA2F2LWS");
		PrestaShopMapper mapper = new PrestaShopMapper(web);
		mapper.setListener(new PrestaShopMapperListener(){

			@Override
			public void sendException(Exception ex) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void sendResponseHash(String hash) {
				System.out.println("Response hash: " + hash);
			}
			
		});
		try {
			//StoreDescription desc = mapper.list(StoreDescription.class);
			
			/*System.out.println("------------------------------------");
			System.out.printf("Shop name: %s\n", desc.getShopName());
			System.out.printf("Customer: GET: %s, POST: %s, PUT: %s, DELETE: %s, HEAD: %s\n", 
					desc.getCustomers().isGet(),
					desc.getCustomers().isPost(),
					desc.getCustomers().isPut(),
					desc.getCustomers().isDelete(),
					desc.getCustomers().isHead());
			System.out.printf("Customer description: %s\n", desc.getCustomers().getDescription());
			System.out.printf("Customer endPoint: %s\n", desc.getCustomers().getEndPoint());
			System.out.printf("Customer schemas: %d\n", desc.getCustomers().getSchemas().size());
			for(int i = 0; i < desc.getCustomers().getSchemas().size(); i++){
				System.out.printf("\t%s: %s\n", desc.getCustomers().getSchemas().get(i).getEndPoint(), 
						desc.getCustomers().getSchemas().get(i).getType());
			}
			
			System.out.printf("Categories: GET: %s, POST: %s, PUT: %s, DELETE: %s, HEAD: %s\n", 
					desc.getCategories().isGet(),
					desc.getCategories().isPost(),
					desc.getCategories().isPut(),
					desc.getCategories().isDelete(),
					desc.getCategories().isHead());
			System.out.printf("Categories description: %s\n", desc.getCategories().getDescription());
			System.out.printf("Categories endPoint: %s\n", desc.getCategories().getEndPoint());
			System.out.printf("Categories schemas: %d\n", desc.getCategories().getSchemas().size());
			for(int i = 0; i < desc.getCustomers().getSchemas().size(); i++){
				System.out.printf("\t%s: %s\n", desc.getCategories().getSchemas().get(i).getEndPoint(), 
						desc.getCategories().getSchemas().get(i).getType());
			}
			
			System.out.printf("Customer GET: %s\n", desc.isAllowed(Resources.customers, PrestaShopRequest.METHOD_GET));
			System.out.printf("Customer POST: %s\n", desc.isAllowed(Resources.customers, PrestaShopRequest.METHOD_POST));
			System.out.printf("Customer PUT: %s\n", desc.isAllowed(Resources.customers, PrestaShopRequest.METHOD_PUT));
			System.out.printf("Customer DELETE: %s\n", desc.isAllowed(Resources.customers, PrestaShopRequest.METHOD_DELETE));
			System.out.printf("Customer HEAD: %s\n", desc.isAllowed(Resources.customers, PrestaShopRequest.METHOD_HEAD));
			
			System.out.printf("Categories GET: %s\n", desc.isAllowed(Resources.categories, PrestaShopRequest.METHOD_GET));
			System.out.printf("Categories POST: %s\n", desc.isAllowed(Resources.categories, PrestaShopRequest.METHOD_POST));
			System.out.printf("Categories PUT: %s\n", desc.isAllowed(Resources.categories, PrestaShopRequest.METHOD_PUT));
			System.out.printf("Categories DELETE: %s\n", desc.isAllowed(Resources.categories, PrestaShopRequest.METHOD_DELETE));
			System.out.printf("Categories HEAD: %s\n", desc.isAllowed(Resources.categories, PrestaShopRequest.METHOD_HEAD));
			
			//Customers customer = new Customers();
			//customer.setId(1);*/
			List<Filter> filters = Collections.emptyList();
			//Customers result = mapper.list(Customers.class, Arrays.asList("firstname", "lastname"), filters, Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Customers result = mapper.listFullDisplay(Customers.class, filters, Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			/*System.out.printf("CUSTOMERS: %d\n", result.size());
			for(int i = 0; i < result.size(); i++){
				Customer cus = result.getCustomer(i);
				System.out.printf("%s,  %s\n", cus.getLastName(), cus.getFirstName());
			}*/
			System.out.println("----------------------------------------------");
			Field[] fields = Customer.class.getDeclaredFields();
			for(int index = 0; index < result.size(); index++){
				for(Field f : fields){
					f.setAccessible(true);
					System.out.printf("%s: %s\n", f.getName(), f.get(result.get(index)));
					f.setAccessible(false);
					/*if(f.getType().getSimpleName().equalsIgnoreCase("associations")){
						Associations asso = result.get(index).getAssociations();
						System.out.printf("\t%d Associations groups\n", asso.getGroups().size());
						for(int aindex = 0; aindex < asso.getGroups().size(); aindex++){
							System.out.printf("\tid: %d\n", asso.getGroups().get(aindex).getId());
						}
					}*/
				}
			}
			//web.setDescription(desc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*GetRequest get = new GetRequest().withResource(Resources.customers).withFullDisplay(true);//.withFields("firstname", "lastname", "id_default_group");
		try {
			InputStream stream = web.executeRequest(get);
			assertNotNull(stream);
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
			String line; 
			while((line = reader.readLine()) != null){
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}