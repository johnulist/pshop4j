/**
 * 
 */
package com.edgaragg.pshop4j.test;

import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.edgaragg.pshop4j.PrestaShopWebservice;
import com.edgaragg.pshop4j.model.Filter;
import com.edgaragg.pshop4j.model.Limit;
import com.edgaragg.pshop4j.model.Sort;
import com.edgaragg.pshop4j.modeling.PrestaShopMapper;
import com.edgaragg.pshop4j.modeling.PrestaShopMapperListener;
import com.edgaragg.pshop4j.pojos.PrestaShopPojo;
import com.edgaragg.pshop4j.pojos.associations.Associations;
import com.edgaragg.pshop4j.pojos.entities.Category;
import com.edgaragg.pshop4j.pojos.entities.Customer;
import com.edgaragg.pshop4j.pojos.entities.Language;
import com.edgaragg.pshop4j.pojos.list.Categories;
import com.edgaragg.pshop4j.pojos.list.Customers;
import com.edgaragg.pshop4j.pojos.list.Languages;
import com.edgaragg.pshop4j.pojos.list.PrestaShopPojoList;

/**
 * @author Edgar Gonzalez
 *
 */
public class Pshop4jGet {

	@Test
	public void test() {
		long start = Calendar.getInstance().getTimeInMillis();
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
			//web.setDescription(desc);
			
			List<Filter> filters = Collections.emptyList();
			
			//Customers result = mapper.list(Customers.class, Arrays.asList("firstname", "lastname"), filters, Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			Categories result = mapper.listFullDisplay(Categories.class, filters, Sort.EMPTY_SORT, Limit.EMPTY_LIMIT);
			/*System.out.printf("CUSTOMERS: %d\n", result.size());
			for(int i = 0; i < result.size(); i++){
				Customer cus = result.getCustomer(i);
				System.out.printf("%s,  %s\n", cus.getLastName(), cus.getFirstName());
			}*/
			System.out.println("----------------------------------------------");
			Field[] fields = Category.class.getDeclaredFields();
			System.out.println("Results: " + result.size());
			for(int index = 0; index < result.size(); index++){
				for(Field f : fields){
					f.setAccessible(true);
					System.out.printf("%s: ", f.getName());
					System.out.printf("%s\n", f.get(result.get(index)));
					f.setAccessible(false);
					
					/*if(f.getType().getSimpleName().equalsIgnoreCase("associations")){
						Associations asso = result.get(index).getAssociations();
						System.out.printf("\t%d Associations groups\n", asso.getAssociation().size());
						for(PrestaShopPojoList<?> pojos : asso.getAssociation()){
							for(int aindex = 0; aindex < pojos.size(); aindex++){
								 System.out.println(pojos.get(aindex).getClass().getSimpleName());
							}	
						}
						
					}*/
				}
			}
			
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
		
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.printf("Execution time: %d seconds\n", (end - start)/1000);
	}

}
