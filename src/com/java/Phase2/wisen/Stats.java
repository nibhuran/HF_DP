package com.java.Phase2.wisen;

import java.util.*;
import java.util.concurrent.*;

public class Stats {
        public static class StatisticsAggregatorImpl implements StatisticsAggregator {

            public static class Stock{
                double averagePrice;
                Integer count = 0;

                public double getAveragePrice() {
                    return averagePrice;
                }

                public void setAveragePrice(double averagePrice) {
                    this.averagePrice = averagePrice;
                }

                public Integer getCount() {
                    return count;
                }

                public void setCount(Integer count) {
                    this.count = count;
                }
            }

            Map<String, Stock> map = new ConcurrentHashMap<>();

            @Override
            public void putNewPrice(String symbol, double price) {
                // YOUR CODE HERE
                if(map.get(symbol) != null){
                    Stock stock = map.get(symbol);
                    stock.setAveragePrice((stock.getAveragePrice() * stock.getCount() + price)/ (stock.getCount() + 1) );
                    stock.setCount(stock.getCount() + 1);
                    map.put(symbol, stock);
                } else {
                    Stock stock = new Stock();
                    stock.setCount(1);
                    stock.setAveragePrice(price);
                    map.put(symbol, stock);
                }
            }

            @Override
            public double getAveragePrice(String symbol) {
                // YOUR CODE HERE
                return map.get(symbol).getAveragePrice();
            }

            @Override
            public int getTickCount(String symbol) {
                // YOUR CODE HERE
                return map.get(symbol).getCount();
            }
        }

    ////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

    public interface StatisticsAggregator {
        // This is an input. Make note of this price
        public void putNewPrice(String symbol, double price);

        // Get the average price
        public double getAveragePrice(String symbol);

        // Get the total number of prices recorded
        public int getTickCount(String symbol);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            final StatisticsAggregator stats = new StatisticsAggregatorImpl();
            final Set<String> symbols = new TreeSet<>();

            String line = scanner.nextLine();
            String[] inputs = line.split(",");
            int threads = Integer.parseInt(inputs[0]);
            ExecutorService pool = Executors.newFixedThreadPool(threads);
            for (int i = 1; i < inputs.length; ++i) {
                String[] tokens = inputs[i].split(" ");
                final String symbol = tokens[0];
                symbols.add(symbol);
                final double price = Double.parseDouble(tokens[1]);
                pool.submit(new Runnable() {
                    @Override
                    public void run() {
                        stats.putNewPrice(symbol, price);
                    }
                });

            }
            pool.shutdown();
            try {
                pool.awaitTermination(5000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (String symbol : symbols) {
                System.out.println(String.format("%s %.4f %d", symbol,
                        stats.getAveragePrice(symbol),
                        stats.getTickCount(symbol)));
            }
        }
        scanner.close();

    }
}