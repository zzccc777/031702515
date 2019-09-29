package addressbook;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.Scanner;
import java.io.*;
public class MAIN {
	
		public  static void main(String[] args)
		{
		     
			    /*String input="F:\\input.txt";
			    String output="F:\\output.txt";
				String encoding="UTF-8";*/
				
				
				try
				{
					File f = new File(args[0]);
		            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_8));
		            BufferedWriter out = new BufferedWriter(new FileWriter(args[1]));
		            String s;
				   /* InputStreamReader read=new InputStreamReader(new FileInputStream(file),encoding);
				    BufferedReader reader = new BufferedReader((read));
				    String s=null;*/
				    while((s=in.readLine())!=null)
				    {
				    	System.out.println(s);
				    		int l=s.length()-1;
				    		s=s.substring(0,l);
				    		String[] arr=s.split("!");
				    		String lv=arr[0];
				    		s=arr[1];
				
				    		String[] str=s.split(",");
				    		String name=str[0];
				    		s = str[1];
				
				    		Pattern p = Pattern.compile("\\d{11}");
				    		Matcher m = p.matcher(str[1]);
				    		String number="";
				    		if (m.find())
				    		{
				    			number=m.group();
				    		}
	            

				    		String address = str[1].replaceAll("\\d{11}", "");
				    		address=address.replaceAll("\\.", "");
				    		/*StringBuilder sb = new StringBuilder(address);
				    		sb.insert(2,"");
				    		address=sb.toString();*/
				    		String address1 = address.substring(0,2);
				    		if(address1.equals("北京")||address1.equals("上海")||address1.equals("天津")||address1.equals("重庆")||address1.equals("内蒙")||address1.equals("新疆")||
				    				address1.equals("广西")||address1.equals("宁夏"))
				    		{
				    			
				    		}
				    		else
				    		{
				    			if(address1.equals("黑龙"))
				    			{
				    				String address2 = address.substring(3,4);
				    				if(address2.equals("省"))
				    				{
				    					if(address.charAt(6)!='市')    {
				    						
				    						StringBuilder bq = new StringBuilder(address);
								    		bq.insert(6,'市');
								    		address=bq.toString();
				    					}
				    					
				    				}
				    				else
				    				{
				    					StringBuilder bq = new StringBuilder(address);
							    		bq.insert(3,"省");
							    		address=bq.toString();
							    		if(address.charAt(6)!='市')
				    					{
				    						StringBuilder ba = new StringBuilder(address);
								    		ba.insert(6,"市");
								    		address=ba.toString();
				    					}
				    				}
				    			}
				    			else
				    			{
				    				String address2 = address.substring(2,3);
				    				if(address2.equals("省"))
				    				{
				    					if(address.charAt(5)!='市')
				    					{
				    						StringBuilder bq = new StringBuilder(address);
								    		bq.insert(5,"市");
								    		address=bq.toString();
				    					}
				    				}
				    				else
				    				{
				    					StringBuilder bq = new StringBuilder(address);
							    		bq.insert(2,"省");
							    		address=bq.toString();
							    		if(address.charAt(5)!='市')
				    					{
				    						StringBuilder ba = new StringBuilder(address);
								    		ba.insert(5,"市");
								    		address=ba.toString();
				    					}
				    				}
				    			}
				    		}
				    		System.out.println(address);
				    		String province=null,city=null,country=null,town=null,village=null,road=null,num=null;
				    		if(lv.equals("1"))
				    		{
				    			String regex="(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市)(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市|.*?县)(?<county>[^县]+县|.+区|.+市|.+旗|.+海域|.+岛)?(?<town>[^区]+区|.+镇)?(?<village>.*)";
				    			Matcher mm=Pattern.compile(regex).matcher(address);
				    		    List<Map<String,String>> table=new ArrayList<Map<String,String>>();
				    		    Map<String,String> row=null;
				    		    while(mm.find())
				    		    {   
				    		            row=new LinkedHashMap<String,String>();
				    		            province=mm.group("province");
				    		            row.put("province", province==null?"":province.trim());
				    		            city=mm.group("city");
				    		            row.put("city", city==null?"":city.trim());
				    		            country=mm.group("county");
				    		            row.put("county", country==null?"":country.trim());
				    		            town=mm.group("town");
				    		            row.put("town", town==null?"":town.trim());
				    		            village=mm.group("village");
				    		            row.put("village", village==null?"":village.trim());
				    		            table.add(row);
				    		        
				    		    }     
				    				out.write("\r\n"+"     "+"{"+"\r\n");
				    				out.write("         "+"姓名"+name+" \r\n");
				    				out.write("         "+"手机"+number+"  "+"\r\n");
				    				out.write("         "+"地址"+"["+"\r\n");
				    				out.write("            "+'"'+province+'"'+"\r\n");
				    				out.write("            "+'"'+city+'"'+"\r\n");
				    				out.write("            "+'"'+country+'"'+"\r\n");
				    				out.write("            "+'"'+town+'"'+"\r\n");
				    				out.write("            "+'"'+village+'"'+"\r\n");
				    				out.write("         "+"]"+"\r\n");
				    				out.write("},"+"\r\n");
				    				out.close();
				    		
				    			/*System.out.println(lv);
					    		System.out.println(name);
					    		System.out.println(number);
					    		System.out.println(address);
					    		System.out.println(province);
					    		System.out.println(city);
					    		System.out.println(country);
					    		System.out.println(town);
					    		System.out.println(village);*/
				    		}
				    		else
				    		{
				    			 String regex = "(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市)?(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市|.*?县|.*?直辖市)?(?<county>[^县]+县|.+?区|.+县级市|.+旗|.+海域|.+岛)?(?<town>[^区]+区|.+镇|.+街|.+乡)?(?<road>[^路]+街|.*?巷|.*?路|.*?大街)?(?<num>[^号]+门牌号|.*?号)?(?<village>.*)";
				                 Pattern p2 = Pattern.compile(regex);
				                 Matcher m2 = p2.matcher(address);
				                 if (m2.find()) {
				                     province = m2.group("province");
				                     city = m2.group("city");
				                     country = m2.group("county");
				                     town = m2.group("town");
				                     road = m2.group("road");
				                     num = m2.group("num");
				                     village = m2.group("village");
				                 }
				                 province=(province==null?"":province);
				                 city=(city==null?"":city);
				                 town=(town==null?"":town);
				                 country=(country==null?"":country);
				                 road = (road==null?"":road);
				                 num = (num==null?"":num);
				                 village=(village==null?"":village);
				    		        
				    		    }    
				    		out.write("\r\n"+"     "+"{"+"\r\n");
				    		out.write("         "+"姓名"+name+" \r\n");
				    		out.write("         "+"手机"+number+"\r\n");
				    		out.write("         "+"地址"+"["+"\r\n");
				    		out.write("            "+'"'+province+'"'+"\r\n");
				    		out.write("            "+'"'+city+'"'+"\r\n");
				    		out.write("            "+'"'+town+'"'+"\r\n");
				    		out.write("            "+'"'+country+'"'+"\r\n");
				    		out.write("            "+'"'+road+'"'+"\r\n");
				    		out.write("            "+'"'+num+'"'+"\r\n");
				    		out.write("            "+'"'+village+'"'+"\r\n");
				    		out.write("         "+"]"+"\r\n");
				    		out.write("},"+"\r\n");
				    		out.close();
				    		    /*System.out.println(lv);
					    		System.out.println(name);
					    		System.out.println(number);
					    		System.out.println(address);
					    		System.out.println(province);
					    		System.out.println(city);
					    		System.out.println(country);
					    		System.out.println(town);
					    		System.out.println(village);
					    		System.out.println(road);
					    		System.out.println(num);*/
				    		}
				    		
				    	
				
				    }

				catch(Exception e)
				{
					System.out.println("Error in open inputfile");
					e.printStackTrace();
				}
			//m.close();
		
				
	}
	}


