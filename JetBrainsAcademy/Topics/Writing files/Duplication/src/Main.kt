// Write your code here. Do not import any libraries
val text = readLine()!!
val myFile = File("MyFile.txt")

myFile.writeText(text)
myFile.appendText(text)
