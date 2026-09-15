class MovieRentingSystem {

    static class Copy {
        int shop;
        int movie;
        int price;

        Copy(int shop, int movie, int price) {
            this.shop = shop;
            this.movie = movie;
            this.price = price;
        }
    }

    Map<Integer, TreeSet<Copy>> available = new HashMap<>();
    TreeSet<Copy> rented;
    Map<Long, Integer> priceMap = new HashMap<>();

    Comparator<Copy> availableComparator = (a, b) -> {
        if (a.price != b.price) {
            return Integer.compare(a.price, b.price);
        }

        return Integer.compare(a.shop, b.shop);
    };

    Comparator<Copy> rentedComparator = (a, b) -> {
        if (a.price != b.price) {
            return Integer.compare(a.price, b.price);
        }

        if (a.shop != b.shop) {
            return Integer.compare(a.shop, b.shop);
        }

        return Integer.compare(a.movie, b.movie);
    };

    public MovieRentingSystem(int n, int[][] entries) {

        rented = new TreeSet<>(rentedComparator);

        for (int[] entry : entries) {
            int shop = entry[0];
            int movie = entry[1];
            int price = entry[2];

            long key = getKey(shop, movie);

            priceMap.put(key, price);

            available
                .computeIfAbsent(
                    movie,
                    k -> new TreeSet<>(availableComparator)
                )
                .add(new Copy(shop, movie, price));
        }
    }

    public List<Integer> search(int movie) {

        List<Integer> result = new ArrayList<>();

        TreeSet<Copy> set = available.get(movie);

        if (set == null) {
            return result;
        }

        int count = 0;

        for (Copy copy : set) {
            result.add(copy.shop);

            count++;

            if (count == 5) {
                break;
            }
        }

        return result;
    }

    public void rent(int shop, int movie) {

        long key = getKey(shop, movie);
        int price = priceMap.get(key);

        Copy copy = new Copy(shop, movie, price);

        available.get(movie).remove(copy);
        rented.add(copy);
    }

    public void drop(int shop, int movie) {

        long key = getKey(shop, movie);
        int price = priceMap.get(key);

        Copy copy = new Copy(shop, movie, price);

        rented.remove(copy);
        available.get(movie).add(copy);
    }

    public List<List<Integer>> report() {

        List<List<Integer>> result = new ArrayList<>();

        int count = 0;

        for (Copy copy : rented) {
            result.add(Arrays.asList(copy.shop, copy.movie));

            count++;

            if (count == 5) {
                break;
            }
        }

        return result;
    }

    private long getKey(int shop, int movie) {
        return ((long) shop << 32) | movie;
    }
}