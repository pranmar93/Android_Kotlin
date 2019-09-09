package com.example.ddflibrary

import java.io.*

class FileOperation {

    companion object ReadFile{

        fun fileRead(filePath: String): String?{

            var line: String?

            try {
                val fileInputStream = FileInputStream(filePath)
                val inputStreamReader = InputStreamReader(fileInputStream)
                val bufferedReader = BufferedReader(inputStreamReader)
                val stringBuilder = StringBuilder()
                line = bufferedReader.readLine()
                while (line != null) {
                    stringBuilder.append(line + System.getProperty("line.separator"))
                    line = bufferedReader.readLine()
                }
                line = stringBuilder.toString()
                fileInputStream.close()
                bufferedReader.close()

            } catch (ex: FileNotFoundException) {
                throw ex
            } catch (ex: IOException) {
                throw ex
            } catch (ex: Exception) {
                throw ex
            }

            return line
        }

        fun fileWrite(folder: String, filename: String, data: String): Boolean{

            try{
                val writeFolderPath = File(folder)
                if (!writeFolderPath.exists()) {
                    writeFolderPath.mkdirs()
                }

                val writeFilePath = File("$folder/$filename")
                if(!writeFilePath.exists()){
                    writeFilePath.createNewFile()
                }

                val fileOutputStream = FileOutputStream(writeFilePath, true)
                fileOutputStream.write((data + System.getProperty("line.separator")).toByteArray())
                fileOutputStream.close()

                return true

            } catch (ex: IOException) {
                throw ex
            } catch (ex: Exception) {
                throw ex
            }
        }
    }

}