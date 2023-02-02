package stepdefinitions;

import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

public class DataTableTest{
	@When("I want read the data from data table")
	public void i_want_read_the_data_from_data_table(DataTable dataTable) {
	   List<List<String>> table = dataTable.asLists();
	   String name=table.get(0).get(0);//Nithesh
	   System.out.println(name);
	   String email=table.get(1).get(1);
	   System.out.println(email);
	   String num=table.get(0).get(2);//abcd
	   System.out.println(num);
	}

}
