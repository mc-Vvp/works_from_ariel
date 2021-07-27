import java.util.*;
class EX2
{
  
 public static void main(String[] args) {
   int [][][] image=MyImageIO.readImageFromFile("C://Users/maxim/Pictures/mv.jpg");
   int [][]grey = rgb2gray(image);
   int [][][]rotate = rotate90(image);
   int n = 10;
   double factor_h = 0.3;
   double factor_w = 2;
   int [][][]smooth1 = Smooth(image,n);
   int [][]scale= scaleup(factor_h,factor_w,grey);
   MyImageIO.writeImageToFile("C://Users/maxim/Pictures/mv1.jpg",scale);
  }
  
  public static int[][] rgb2gray(int[][][] im){
   int [][] gray = new int [im[0].length][im[0][0].length];{
   for (int i=0; i<im[0].length; i++) {
    for (int j=0; j<im[0][0].length;j++) {
     int sum = (int)(((im[0][i][j]*0.3)+ (im[1][i][j]*0.59) + (im[2][i][j]*0.11)));
     gray[i][j]=sum* 255; 
    }
   }
    return gray;
    
    
  }

 
 }
  //Q2
  
  
  public static int[][][] rotate90(int[][][] im){
  int [][][] rotate = new int [3][im[0][0].length][im[0].length];
   for (int i=0; i<im[0][0].length;i++) {
    for(int j=0; j<im[0].length;j++) {
     rotate[0][i][j]=im[0][im[0].length-1-j][i];
     rotate[1][i][j]=im[1][im[0].length-1-j][i];
     rotate[2][i][j]=im[2][im[0].length-1-j][i];
    }
    
   }
   return rotate;
  
  } 
  //Q3
  public static int [][][] Smooth(int [][][]im,int n){
   int [][][] smooth1 = new int [3][im[0].length][im[0][0].length];
   for (int color=0; color<3;color++) {
   for (int i=0; i<im[0].length; i++) {
    for (int j=0; j<im[0][0].length; j++) {
     
     double sum1 = 0; 
     int counter = 0;
     for (int k=i-n; k<i+n; k++) {
      for (int l=j-n; l<j+n;l++ ) {
       if(k>=0 && k<im[0].length && l>=0 && l<im[0][0].length) {
        sum1 += im[color][k][l];
          counter++;   
       }
      }
     }
    smooth1[color][i][j]=(int)(sum1/counter);
    smooth1[color][i][j]=(int)(sum1/counter);
    smooth1[color][i][j]=(int)(sum1/counter);
    }
   }
   }
 return smooth1;
  }
  
  //Q4
  public static int[][] scaleup(double factor_h, double factor_w, int[][] im){
   int scale[][] = new int[(int) (im.length*factor_h)][(int)(im[0].length*factor_w)];
   for (int i=0; i<im.length; i++) {
    for (int j=0; j<im[0].length; j++) {
     for (int fh=0; fh<factor_h;fh++) {
      for (int fw=0; fw<factor_w; fw++) {
       scale[(int)((i*factor_h)+fh)][(int)((j*factor_w)+fw)]=im[i][j];
      }
     }
     //scale[i][j]=im[i*factor_h]
    }
   }
   return scale;
   
  }
}