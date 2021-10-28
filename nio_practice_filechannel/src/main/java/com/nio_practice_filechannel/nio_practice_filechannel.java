package com.nio_practice_filechannel;
import java.nio.*;
import java.nio.charset.*;
import java.nio.channels.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class nio_practice_filechannel {

    private static Object IOException;

    public static void main(String[] args) {
        final int SIZE_OF_BUFFER = 1024;
        try{
            RandomAccessFile RAF = new RandomAccessFile("test.txt","rw");
            FileChannel FC = RAF.getChannel();
            ByteBuffer BF1 = ByteBuffer.allocate(SIZE_OF_BUFFER);//initially, write mode
            ByteBuffer BF2 = ByteBuffer.allocate(SIZE_OF_BUFFER);//initially, write mode
            nio_buffer_util bufUtil = new nio_buffer_util();    // class with method for checking position, limit, capacity

            BF1.put("test_data".getBytes(StandardCharsets.UTF_8));//test string to put in file channel

            BF1.flip(); // flip() to set BF1 read mode
            FC.write(BF1);// write data into FileChannel FC from ByteBuffer BF1
            FC.position(0);// when wirte(), position changes. always aware that the position would be changed if you do I/O Operation
            int byteRead = FC.read(BF2);// write data into ByteBuffer BF2 from FileChannel FC
            System.out.print(byteRead);
            System.out.print('\n');
            BF2.flip();// flip() to set BF2 read mode
            System.out.println(Charset.forName("UTF-8").decode(BF2).toString()); // print String converted from ByteBuffer BF2






        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }

    }
}
