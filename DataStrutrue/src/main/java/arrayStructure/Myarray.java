package arrayStructure;

public class Myarray {
    private long[] arr;
    //有效元素长度
    private int elements;

    public Myarray() {
        arr = new long[50];
    }

    public Myarray(int maxSize) {
        arr = new long[maxSize];
    }

    /*
    * 添加数据
    * */
    public void insert(long value){
        int i;
        for ( i = 0; i < elements; i++) {
            if(arr[i] > value){
                break;
            }
        }

        for (int j = elements; j > i; j--) {
            arr[j] = arr[j-1];
        }

        arr[i] = value;
        elements++;
    }
    /*显示对应的数据*/
    public void display(){
        System.out.print("[");
        for (int i = 0; i < elements; i++) {
            System.out.print(arr[i]+"");
        }
        System.out.print("]");
    }
//    查找数据
    public int search(long value){
        int i;
        for(i=0;i<elements;i++){
            if(value == arr[i]){
                break;
            }
        }

        if(i == elements){
            return -1;
        }else{
            return i;
        }
    }
    /*二分法查找*/
    public int binarySearch(long value){
        int middle = 0;//中间坐标值初始化
        int low = 0;//最左边的index
        int pow = elements;//最右边的index;

        while(true){
            middle = (pow + low)/2;

            if(arr[middle] == value){
                return middle;
            }else if(low > pow){
                return -1;
            }else{
                if(arr[middle] > value){
                    pow = middle - 1;
                }else{
                    low = middle +1;
                }
            }
        }
    }
    public long get(int index){
        if(index >= elements){
            throw new ArrayIndexOutOfBoundsException();
        }else{
            return arr[index];
        }


    }
    /*删除数组当中的数据*/
    public void delete(int index){
        if(index >= elements || index<0){
            throw new ArrayIndexOutOfBoundsException();
        }else{
            for (int i = index; i < elements; i++) {
                arr[index] = arr[index+1];
            }
            elements--;
        }
    }

     //    更新数据
    public void change(int index,int newvalue){
        if(index>=elements || index<0){
            throw new ArrayIndexOutOfBoundsException();
        }else{
            for (int i = index; i < elements; i++) {
                arr[index] = newvalue;
            }
        }
    }

}
