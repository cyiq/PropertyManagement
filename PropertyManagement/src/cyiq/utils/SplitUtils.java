package cyiq.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SplitUtils {

	public List<String> splits(String message){
		String[] params = message.split("bobo");
		List<String> list = new ArrayList<String>();
		for(int i=0;i<params.length;i++){
			list.add(params[i]);
		}
		return list;
	}
	
	
	public List<List<String>> splitName(String message){
		String [] params = message.split("bobo");
		List<List<String>> list = new ArrayList<List<String>>();
		List<String> listMessage = null;
		for(int i=0;i<params.length;i++){
			listMessage = new ArrayList<String>();
			String [] ss = params[i].split(":");
			for(int j=0;j<ss.length;j++){
				listMessage.add(ss[j]);
			}
			list.add(listMessage);
		}
		return list;
	}
	
	public String toMessage(List<List<String>> list){
		String message = "";
		for(int i=0;i<list.size();i++){
			for(int j = 0; j < list.get(i).size(); j++){
				message+=list.get(i).get(j);
				if(j==0){
					message+=":";
				}
			}
			if(i != list.size()-1){
				message+="bobo";
			}
		}
		return message;	
	}
}
