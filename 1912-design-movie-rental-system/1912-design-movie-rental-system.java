import java.util.*;

class MovieRentingSystem {

    private static class Movie implements Comparable<Movie> {
        int shop, movie, price;
        Movie(int shop, int movie, int price) {
            this.shop = shop;
            this.movie = movie;
            this.price = price;
        }
        @Override
        public int compareTo(Movie o) {
            if (this.price != o.price) return this.price - o.price;
            if (this.shop != o.shop) return this.shop - o.shop;
            return this.movie - o.movie;
        }
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Movie)) return false;
            Movie m = (Movie) o;
            return shop == m.shop && movie == m.movie && price == m.price;
        }
        @Override
        public int hashCode() {
            return Objects.hash(shop, movie, price);
        }
    }

    private final Map<Integer, TreeSet<Movie>> available = new HashMap<>();
    private final TreeSet<Movie> rented = new TreeSet<>();
    private final Map<Integer, Map<Integer, Movie>> lookup = new HashMap<>(); // shop -> movie -> Movie

    public MovieRentingSystem(int n, int[][] entries) {
        for (int[] e : entries) {
            int shop = e[0], movieId = e[1], price = e[2];
            Movie m = new Movie(shop, movieId, price);

            // available map
            available.computeIfAbsent(movieId, k -> new TreeSet<>()).add(m);

            // lookup map
            lookup.computeIfAbsent(shop, k -> new HashMap<>()).put(movieId, m);
        }
    }

    public List<Integer> search(int movieId) {
        List<Integer> res = new ArrayList<>();
        TreeSet<Movie> set = available.get(movieId);
        if (set == null) return res;
        int count = 0;
        for (Movie m : set) {
            if (count++ == 5) break;
            res.add(m.shop);
        }
        return res;
    }

    public void rent(int shop, int movieId) {
        Movie m = lookup.get(shop).get(movieId);
        available.get(movieId).remove(m);
        rented.add(m);
    }

    public void drop(int shop, int movieId) {
        Movie m = lookup.get(shop).get(movieId);
        rented.remove(m);
        available.get(movieId).add(m);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        for (Movie m : rented) {
            if (count++ == 5) break;
            res.add(Arrays.asList(m.shop, m.movie));
        }
        return res;
    }
}