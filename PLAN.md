# Yooply: AI-Powered Dual-Account Financial Planner

## Project Overview
Yooply is a modern, AI-enhanced financial tracking application designed for couples, roommates, or co-managers. It solves the friction of managing shared expenses alongside personal finances by offering a unified dashboard with distinct "Individual" and "Shared" ledgers. 

By leveraging machine learning and advanced data analytics, Yooply goes beyond traditional budgeting apps to proactively identify cost-cutting opportunities and provide actionable insights on monthly spending habits.

## The Problem
Managing shared finances traditionally requires either fully merged bank accounts or tedious manual reconciliation (e.g., splitting bills in spreadsheets). Existing solutions lack a seamless way to view personal financial health alongside shared obligations, and they rarely offer proactive, intelligent advice on optimizing expenses.

## The Solution
Yooply provides a "Dual-Ledger" architecture. Users can maintain their autonomous personal ledger while seamlessly contributing to and tracking a shared ledger. The platform uses AI to analyze spending patterns across both ledgers, automatically categorizing transactions and suggesting areas for financial optimization.

## Core Features
- **Dual-Wallet Architecture & Bank Sync:** Connect real bank accounts to automatically ingest and track transactions, while seamlessly toggling between or combining views for Individual and Shared ledgers.
- **Smart Categorization:** Automated expense tagging and sorting using AI, with the ability for users to manually override categories. The AI learns from these user overrides to improve future categorization accuracy.
- **AI Financial Advisor:** An integrated AI engine that analyzes spending velocity, recurring subscriptions, and categorization to suggest actionable cost-cutting strategies.
- **Comprehensive Analytics Dashboard:** Visualized monthly reports comparing individual vs. shared spending, budget adherence, and historical trends. Reports track day-by-day pacing from the 1st of the month, alerting users if specific budgets (e.g., shared food) are depleting faster than expected. Additionally, the dashboard includes a month-over-month comparison report to track long-term spending changes and savings growth.
- **Dynamic Fixed/Variable Splitting:** The system calculates exactly how much money each partner needs to contribute to the shared account each month. It automatically anticipates fixed costs (mortgage, energy, water, etc.) based on the previous month's amounts (with the ability to edit these amounts). Any additional funds contributed are explicitly allocated to variable shared expenses.

## Architecture & Technology Stack

Yooply is built with a focus on scalability, type safety, and data integrity—principles essential for modern FinTech applications.

### Backend: Kotlin 
- **Why:** Kotlin offers robust type safety, null-safety, and seamless JVM interoperability. It is a dominant language in modern Android and enterprise FinTech backend development, allowing for highly concurrent, scalable, and maintainable services.
- **Role:** Handles business logic, secure data routing, AI API communication, and ledger calculations.

### Database: PostgreSQL
- **Why:** Financial applications require strict ACID compliance and relational integrity. PostgreSQL provides enterprise-grade reliability, advanced concurrency control, and robust support for complex queries and JSONB data (useful for flexible AI metadata).
- **Role:** Source of truth for users, ledger entries, shared ledger mappings, and historical analytics.

### Frontend: Next.js + React + TypeScript
- **Why:** Next.js builds on React's component-based architecture with server-side rendering, file-based routing, and built-in API proxying. TypeScript adds compile-time safety. Tailwind CSS provides rapid, consistent styling.
- **Role:** Delivers the interactive monthly dashboards, data visualizations, and user input forms.

### AI Integration: LLM / OpenAI API
- **Why:** Traditional rule-based categorization falls short for nuanced spending behaviors. Leveraging an LLM allows for semantic understanding of transaction descriptions and generation of personalized financial advice. It also enables a continuous learning loop where the system adapts to user-specific categorization preferences over time based on their overrides.
- **Role:** Powers the intelligent categorization engine (with user-override learning capabilities) and the "Cost-Cutting" recommendation feature.

## Technical Goals & Engineering Principles
1. **Data Integrity First:** Ensure zero-loss or misattribution of ledger entries between shared and personal accounts.
2. **Scalability:** Design the backend to handle high-frequency transaction ingestion and complex end-of-month aggregation queries.
3. **Security:** Implement secure authentication and authorization boundaries ensuring users can only access their personal data and authorized shared data.
4. **Clean Code & Testability:** Maintain a high test coverage for ledger calculations using unit and integration testing frameworks.

## Roadmap (MVP)
- [x] **Phase 1: Foundation.** Setup Kotlin backend, PostgreSQL schema, and basic Next.js scaffold.
- [ ] **Phase 2: Core Ledger & Bank Sync.** Implement bank account connections for automated transaction ingestion, basic ledger CRUD operations, and the dynamic fixed/variable shared account calculator.
- [ ] **Phase 3: Dashboard & Reporting.** Build the frontend to display day-by-day budget pacing, month-over-month comparisons, and historical trends.
- [ ] **Phase 4: AI Intelligence.** Integrate the AI engine for transaction categorization, implement the user override feedback loop so AI learns from corrections, and generate the monthly cost-cutting report.