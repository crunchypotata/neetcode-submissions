class TimeMap {

    // Вложенный класс статик — чище для памяти
    private static class Data {
        String value;
        int timestamp;

        public Data(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private Map<String, List<Data>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        // Если ключа еще нет, создаем для него пустой список
        if (!timeMap.containsKey(key)) {
            timeMap.put(key, new ArrayList<>());
        }
        // Достаем список по ключу и добавляем туда новую запись
        timeMap.get(key).add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        // 1. Сначала ПРОВЕРЯЕМ, есть ли вообще такой ключ
        if (!timeMap.containsKey(key)) {
            return "";
        }

        // 2. И только после проверки безопасно достаем список
        List<Data> list = timeMap.get(key);

        // 3. Границы поиска выставляем по размеру СПИСКА, а не всей мапы
        int left = 0;
        int right = list.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Data midData = list.get(mid);

            if (midData.timestamp <= timestamp) {
                result = midData.value; // Запоминаем возможный ответ
                left = mid + 1;         
            } else {
                right = mid - 1;       
            }
        }
        
        return result; 
    }
}