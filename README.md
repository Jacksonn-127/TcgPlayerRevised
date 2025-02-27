Trading Card Price Scraper

📌 Overview

Manually checking the prices of collectible trading cards can be time-consuming. This project automates the process using a web scraper to retrieve the latest market prices for:

Single cards

Graded single cards

Sealed collectible boxes

Using this tool, you can reduce the time spent searching from 60 seconds to just 2 seconds per item—a 96.77% time savings!

🚀 Features

✅ Automatically scrapes prices from TCGPlayer and PriceCharting
✅ Supports multiple item types (raw, graded, sealed)
✅ Exports data to a .csv file for easy tracking
✅ Simple setup with Selenium WebDriver

🛠 Installation & Setup

1. Install Dependencies

Ensure you have Java installed, then set up the required libraries:

Download and install Selenium Java from here

Include Selenium WebDriver and Apache POI (for CSV export) in your Java project

2. Set Up WebDriver

You will need a browser and its corresponding Selenium WebDriver:

Download ChromeDriver from here

Place chromedriver.exe in the chromeDriver/chromedriver-win64/ directory

3. Compile and Run the Program

javac Scraper.java
java Scraper

The script will generate a .csv file containing the prices of your trading card collection.

⚠️ Current Status

⏳ On Hold while I focus on school.🔜 Next Features:

Ability to read URLs from a file for batch processing

Front-end dashboard for better user interaction

📜 License

This project is licensed under the MIT License.
