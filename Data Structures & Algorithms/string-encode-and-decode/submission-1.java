class Solution {

    public String encode(List<String> strs) {

        StringBuilder encodedString = new StringBuilder();
        
        for (String word : strs) {
            encodedString.append(word.length()).append("#").append(word);
        }
        
        return encodedString.toString();
    }

    public List<String> decode(String str) {

        List<String> decodedString = new ArrayList<>();
        int left = 0;
        int right = 0;

        while (left < str.length()) {
            // 1. Находим решетку. right — это индекс решетки
            right = str.indexOf('#', left);

            // 2. Вырезаем кусок с цифрами (между left и решеткой right) и превращаем в int
            int length = Integer.parseInt(str.substring(left, right));

            // 3. Вырезаем само слово, зная его начало и конец
            String temp = str.substring(right + 1, right + 1 + length);
            decodedString.add(temp);
            
            // 4. Прыгаем указателем left на начало СЛЕДУЮЩЕГО слова
            left = right + 1 + length;
        }

        return decodedString;
    }
}
