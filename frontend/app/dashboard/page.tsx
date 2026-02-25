"use client";

import { useEffect, useState } from "react";
import { useRouter } from "next/navigation";
import { getStoredUser, logout, type AuthResponse } from "@/lib/auth";

export default function DashboardPage() {
  const router = useRouter();
  const [user, setUser] = useState<AuthResponse | null>(null);

  useEffect(() => {
    const stored = getStoredUser();
    if (!stored) {
      router.push("/login");
      return;
    }
    setUser(stored);
  }, [router]);

  function handleLogout() {
    logout();
    router.push("/");
  }

  if (!user) return null;

  return (
    <div className="min-h-screen bg-slate-900">
      <header className="border-b border-slate-800">
        <div className="mx-auto flex max-w-5xl items-center justify-between px-6 py-4">
          <div className="flex items-center gap-3">
            <div className="flex h-8 w-8 items-center justify-center rounded-lg bg-emerald-500 text-sm font-bold text-white">
              P
            </div>
            <span className="text-lg font-semibold text-white">PairLedger</span>
          </div>
          <div className="flex items-center gap-4">
            <span className="text-sm text-slate-400">{user.email}</span>
            <button
              onClick={handleLogout}
              className="rounded-lg border border-slate-700 px-3 py-1.5 text-sm text-slate-300 transition hover:border-slate-500 hover:text-white"
            >
              Sign Out
            </button>
          </div>
        </div>
      </header>

      <main className="mx-auto max-w-5xl px-6 py-12">
        <h1 className="text-3xl font-bold text-white">
          Welcome, {user.displayName}
        </h1>
        <p className="mt-2 text-slate-400">
          Your financial dashboard is coming soon.
        </p>

        <div className="mt-8 grid gap-6 md:grid-cols-2">
          <div className="rounded-xl border border-slate-800 bg-slate-800/50 p-6">
            <h2 className="text-sm font-medium uppercase tracking-wider text-slate-400">
              Personal Ledger
            </h2>
            <p className="mt-4 text-2xl font-bold text-white">--</p>
            <p className="mt-1 text-sm text-slate-500">
              Connect your bank to get started
            </p>
          </div>
          <div className="rounded-xl border border-slate-800 bg-slate-800/50 p-6">
            <h2 className="text-sm font-medium uppercase tracking-wider text-slate-400">
              Shared Ledger
            </h2>
            <p className="mt-4 text-2xl font-bold text-white">--</p>
            <p className="mt-1 text-sm text-slate-500">
              Invite your partner to collaborate
            </p>
          </div>
        </div>
      </main>
    </div>
  );
}
