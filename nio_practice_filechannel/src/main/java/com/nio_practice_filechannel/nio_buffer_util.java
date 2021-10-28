package com.nio_practice_filechannel;

import java.nio.Buffer;

public class nio_buffer_util {
    public void print_buffer_status(Buffer b){
        System.out.printf("\n");
        System.out.printf("Position : %d\n",b.position());
        System.out.printf("Capacity : %d\n",b.position());
        System.out.printf("Limit : %d\n",b.limit());
        System.out.printf("\n");
    }
}
