package org.example.dataprocessor;
import java.util.*;

public interface Clean
{
     List<Integer> remove(List<Integer> data);
}

class Remove_z implements Clean{

    @Override
    public List<Integer> remove(List<Integer> data) {
        List<Integer> d =new ArrayList<>();
    for(int i=0;i<data.size();i++){
        if(data.get(i)>=0){
            d.add(data.get(i));
        }

    }
    return d;
    }
}
class Replace_z implements Clean{
    @Override
    public List<Integer> remove(List<Integer> data) {
        List<Integer> d =new ArrayList<>();
        for(int i=0;i<data.size();i++){
            if(data.get(i)<0){
                d.add(0);
            }else {
                d.add(data.get(i));
            }
        }
        return d;
    }
}
