package org.example.dataprocessor;
import java.util.*;


public interface Analysis {
    double getresult(List<Integer> data);
}


class Mean implements Analysis{

    @Override
    public double getresult(List<Integer> data) {
        if(data.size()!=0){
            double mean=0;
            for(int i =0;i<data.size();i++){
                mean+=data.get(i);
            }
            mean/=data.size();
            return mean;
        }
        return Double.NaN;
    }
}
class Median implements Analysis{
    @Override
    public double getresult(List<Integer> data) {
        if(data.size()!=0){
            Collections.sort(data);
            if(data.size()%2==0){
                double av=1;
                av=data.get((data.size()/2)-1)+data.get((data.size()/2));
                return av/2;
            }else {
                return data.get(data.size()/2);
            }
        }
        return Double.NaN;
    }
}
class StandardDeviation implements Analysis{
    @Override
    public double getresult(List<Integer> data) {
        if(data.size()!=0){
            Collections.sort(data);
            Mean mean=new Mean();
            double m=mean.getresult(data);
            double s=0;
            for(int i =0;i<data.size();i++){
                s+=(data.get(i)-m)*(data.get(i)-m);
            }
            s/=data.size();
            return Math.sqrt(s);
        }
        return Double.NaN;
    }
}
class P90_NEAREST_RANK implements Analysis{
    @Override
    public double getresult(List<Integer> data) {
        if(data.size()!=0){
            Collections.sort(data);
            double r=Math.ceil(0.90 * data.size());
            return data.get((int)(r-1));
        }
        return Double.NaN;
    }
}
class TOP3_FREQUENT_COUNT_SUM implements Analysis{
    @Override
    public double getresult(List<Integer> data) {
        if(data.size()!=0){
            Collections.sort(data);
            Map<Integer,Integer> frq=new HashMap<>();
            for(int i =0;i<data.size();i++){
                frq.put(data.get(i),frq.getOrDefault(data.get(i),0)+1);
            }
            List<Map.Entry<Integer, Integer> > list =
                    new LinkedList<Map.Entry<Integer, Integer> >(frq.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
                public int compare(Map.Entry<Integer, Integer> o1,
                                   Map.Entry<Integer, Integer> o2) {
                    return (o1.getValue()).compareTo(o2.getValue());
                }
            });
            double s =0;
            if(list.size()>=3){
//                double s =0;
                s+=list.get(list.size()-1).getValue();
                s+=list.get(list.size()-2).getValue();
                s+=list.get(list.size()-3).getValue();
            }else {
//                double s =0;
                for(int i=0;i<list.size();i++){
                    s+=list.get(i).getValue();
                }
            }
            return s;
        }
        return 0.0;
    }

}
