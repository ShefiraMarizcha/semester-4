package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final double H = 5.0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int T = Integer.parseInt(br.readLine());
            if (T == 0) break;

            for (int i = 0; i < T; i++) {
                String[] input = br.readLine().split(" ");
                int Q = Integer.parseInt(input[0]);
                double A = Double.parseDouble(input[1]);
                double B = Double.parseDouble(input[2]);

                double area = ((A + B) * H / 2.0) * Q;
                sb.append(String.format("%.2f\n", area));
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
