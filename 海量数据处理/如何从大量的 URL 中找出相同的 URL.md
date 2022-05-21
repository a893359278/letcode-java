### 题目描述
给定 a、b 两个文件，各存放 50 亿个 URL，每个 URL 各占 64B，内存限制是 4G。请找出 a、b 两个文件共同的 URL。

### 解题思路

1. 将 a 文件 hash(url) % 1000 放到 ai~a1000 个小文件中
2. 将 b 文件 hash(url) % 1000 放到 bi~b1000 个小文件中
3. 对等读取 ai,bi 程序内使用 HashSet。最后将相同的 url 写入到另外的文件中


### 实现

```java
package com.csp.boot.lekou;

import com.csp.boot.rest.WebController.Obj;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author 陈少平
 * @date 2022-05-16 22:11
 */
public class 大量URL找相同URL {

    public static void main(String[] args) throws IOException {
        String lekou = 大量URL找相同URL.class.getResource("/lekou").getPath();
        System.out.println(lekou);
        splitFile("/lekou/urla.txt",lekou + "/a");
        splitFile("/lekou/urlb.txt",lekou + "/b");


        BufferedWriter writer = new BufferedWriter(new FileWriter(lekou + "/merge.txt"));
        for (int i = 0; i < 1000; i++) {
            HashSet<String> set = new HashSet<>();

            File fa = new File(lekou + "/a" + i + ".txt");
            File fb = new File(lekou + "/b" + i + ".txt");
            if (fa.exists() && fb.exists()) {
                try(BufferedReader readera = new BufferedReader(new FileReader(fa))) {
                    String line;
                    while ((line = readera.readLine()) != null) {
                        set.add(line);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                try(BufferedReader readerb = new BufferedReader(new FileReader(fb))) {
                    String lineb;
                    while ((lineb = readerb.readLine()) != null) {
                        if (set.contains(lineb)) {
                            writer.write(lineb);
                            writer.newLine();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (fa.exists()) {
                fa.delete();
            }

            if (fb.exists()) {
                fb.delete();
            }
        }

        writer.flush();
        writer.close();
    }

    private static void splitFile(String fileName, String target) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(大量URL找相同URL.class.getResourceAsStream(fileName)));

        String line = null;

        Map<Integer, BufferedWriter> map = new HashMap<>();

        while ((line = reader.readLine()) != null) {
            int index = Math.abs(line.hashCode()) % 1000;
            BufferedWriter fos = map.get(index);
            if (null == fos) {
                File file = new File(target + index + ".txt");
                fos = new BufferedWriter(new FileWriter(file));
                map.put(index, fos);
            }

            fos.write(line);
            fos.newLine();
            fos.flush();
        }

        for (BufferedWriter value : map.values()) {
            value.close();
        }
    }
}
```
