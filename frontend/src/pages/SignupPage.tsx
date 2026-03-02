import type { FormEvent } from 'react'
import { useMemo, useState } from 'react'
import { createUser } from '../api/users'
import type { CreateUserRequest, UserRole } from '../types/user'
import './auth.css'

type FormState = CreateUserRequest

type Status =
  | { type: 'idle' }
  | { type: 'submitting' }
  | { type: 'success'; message: string }
  | { type: 'error'; message: string }

const DEFAULT_ROLE: UserRole = 'STUDENT'

function asReadableError(error: unknown): string {
  if (typeof error === 'string') return error
  if (error && typeof error === 'object' && 'message' in error) {
    const maybeMessage = (error as { message?: unknown }).message
    if (typeof maybeMessage === 'string' && maybeMessage.trim()) return maybeMessage
  }
  return 'Signup failed. Please try again.'
}

export default function SignupPage() {
  const [form, setForm] = useState<FormState>({
    userName: '',
    password: '',
    email: '',
    firstName: '',
    lastName: '',
    userRole: DEFAULT_ROLE,
  })
  const [status, setStatus] = useState<Status>({ type: 'idle' })

  const isValid = useMemo(() => {
    return (
      form.firstName.trim().length > 0 &&
      form.lastName.trim().length > 0 &&
      form.userName.trim().length > 0 &&
      form.email.trim().length > 0 &&
      form.password.trim().length >= 6 &&
      form.userRole.trim().length > 0
    )
  }, [form])

  async function onSubmit(event: FormEvent) {
    event.preventDefault()
    if (!isValid) {
      setStatus({ type: 'error', message: 'Please fill all fields (password min 6 chars).' })
      return
    }

    try {
      setStatus({ type: 'submitting' })
      await createUser({
        ...form,
        email: form.email.trim(),
        userName: form.userName.trim(),
        firstName: form.firstName.trim(),
        lastName: form.lastName.trim(),
      })
      setStatus({
        type: 'success',
        message: 'Account created (or already existed). You can now log in.',
      })
    } catch (error) {
      setStatus({ type: 'error', message: asReadableError(error) })
    }
  }

  return (
    <div className="authShell">
      <div className="authCard">
        <div className="authHeader">
          <h1 className="authTitle">Create your account</h1>
          <p className="authSubtitle">Sign up to access the School system.</p>
        </div>

        <form className="authForm" onSubmit={onSubmit}>
          <div className="authGrid">
            <label className="authField">
              <span>First name</span>
              <input
                value={form.firstName}
                onChange={(e) => setForm((s) => ({ ...s, firstName: e.target.value }))}
                autoComplete="given-name"
                required
              />
            </label>

            <label className="authField">
              <span>Last name</span>
              <input
                value={form.lastName}
                onChange={(e) => setForm((s) => ({ ...s, lastName: e.target.value }))}
                autoComplete="family-name"
                required
              />
            </label>
          </div>

          <label className="authField">
            <span>Username</span>
            <input
              value={form.userName}
              onChange={(e) => setForm((s) => ({ ...s, userName: e.target.value }))}
              autoComplete="username"
              required
            />
          </label>

          <label className="authField">
            <span>Email</span>
            <input
              value={form.email}
              onChange={(e) => setForm((s) => ({ ...s, email: e.target.value }))}
              autoComplete="email"
              inputMode="email"
              type="email"
              required
            />
          </label>

          <label className="authField">
            <span>Password</span>
            <input
              value={form.password}
              onChange={(e) => setForm((s) => ({ ...s, password: e.target.value }))}
              autoComplete="new-password"
              type="password"
              minLength={6}
              required
            />
            <span className="authHint">Minimum 6 characters.</span>
          </label>

          <label className="authField">
            <span>Role</span>
            <select
              value={form.userRole}
              onChange={(e) => setForm((s) => ({ ...s, userRole: e.target.value as UserRole }))}
            >
              <option value="PRINCIPAL">Principal</option>
              <option value="ADMINISTRATION">Administration</option>
              <option value="TEACHER">Teacher</option>
              <option value="STUDENT">Student</option>
            </select>
          </label>

          {status.type === 'error' && <div className="authAlert authAlertError">{status.message}</div>}
          {status.type === 'success' && (
            <div className="authAlert authAlertSuccess">{status.message}</div>
          )}

          <button className="authButton" type="submit" disabled={status.type === 'submitting'}>
            {status.type === 'submitting' ? 'Creating...' : 'Create account'}
          </button>
        </form>
      </div>
    </div>
  )
}
