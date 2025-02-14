Web Scraper with FixedThreadPool and CachedThreadPool
Objective: Understand the difference between FixedThreadPool and CachedThreadPool by simulating a web scraper.
Problem Statement:
Given a list of 100 URLs (can be dummy URLs like "http://example.com/pageX"), create a web scraper that "fetches" (simulated with Thread.sleep(200ms)) the page content.
Implement two versions:
Use a FixedThreadPool(10) to process 10 URLs at a time.
Use a CachedThreadPool to process them dynamically.
Compare execution time for both approaches.
