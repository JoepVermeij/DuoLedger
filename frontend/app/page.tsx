import Link from "next/link";

export default function Home() {
  return (
    <div className="flex min-h-screen flex-col items-center justify-center bg-gradient-to-br from-slate-900 via-slate-800 to-slate-900 text-white">
      <main className="flex flex-col items-center gap-8 px-6 text-center">
        <div className="flex items-center gap-3">
          <div className="flex h-12 w-12 items-center justify-center rounded-xl bg-emerald-500 text-2xl font-bold">
            P
          </div>
          <h1 className="text-5xl font-bold tracking-tight">Yooply</h1>
        </div>

        <p className="max-w-md text-lg text-slate-300">
          AI-powered financial planning for couples. Track shared and personal
          expenses in one place.
        </p>

        <div className="flex gap-4">
          <Link
            href="/register"
            className="rounded-lg bg-emerald-500 px-6 py-3 font-semibold text-white transition hover:bg-emerald-400"
          >
            Get Started
          </Link>
          <Link
            href="/login"
            className="rounded-lg border border-slate-600 px-6 py-3 font-semibold text-slate-300 transition hover:border-slate-400 hover:text-white"
          >
            Sign In
          </Link>
        </div>
      </main>
    </div>
  );
}
