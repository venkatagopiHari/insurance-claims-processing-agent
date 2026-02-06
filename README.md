# Autonomous Insurance Claims Processing Agent (Lite)

## Problem Statement
Build a lightweight agent to process FNOL documents:
- Extract key fields
- Identify missing fields
- Route claim workflow
- Provide reasoning

## Approach
1. Read FNOL PDF using Apache PDFBox.
2. Extract important keywords and fields.
3. Check for missing mandatory fields.
4. Apply rule-based routing:
   - Missing fields → Manual Review
   - Injury keywords → Specialist Queue
   - Fraud keywords → Investigation
5. Output structured JSON.

## Tech Stack
- Java
- Apache PDFBox

## Steps to Run
1. Place sample.pdf in project folder.
2. Open project in Java environment.
3. Run Main.java.
4. View JSON output in console.

## Notes
This is a simplified rule-based implementation focusing on clarity and logic.
