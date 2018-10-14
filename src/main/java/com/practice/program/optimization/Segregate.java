package com.practice.program.optimization;

class Segregate
{

    /* Driver Program to test above functions */
    public static void main(String[] args)
    {
        Segregate seg = new Segregate();
        int arr[] = new int[]{0,0, 1, 0, 1,0,1,0, 1,0,1,0,1,0,0,0, 1,0,0};

        seg.segrateBy0and1(arr);

        System.out.print("Array after segregation is ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    private void segrateBy0and1(int arr[]){
        int left =0;
        int right = arr.length-1;
        while(left < right){
            if(arr[left] == 0) {
                left++;
            }else if(arr[right] == 1){
                right --;
            }else {
                arr[left] = 0;
                arr[right] = 1;
            }
        }
    }
}

