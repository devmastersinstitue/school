import type { FormEvent } from 'react'
import { useMemo, useState } from 'react'
import { createUser } from '../api/users'
import type { CreateUserRequest, UserRole } from '../types/user'
import './auth.css'

type FormState = CreateUserRequest

type Mode = 'signup' | 'login'

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
  return 'Request failed. Please try again.'
}

export default function AuthPage() {
  const [mode, setMode] = useState<Mode>('signup')

  const [form, setForm] = useState<FormState>({
    userName: '',
    password: '',
    email: '',
    firstName: '',
    lastName: '',
    userRole: DEFAULT_ROLE,
  })

  const [status, setStatus] = useState<Status>({ type: 'idle' })

  const isSignupValid = useMemo(() => {
    return (
      form.firstName.trim().length > 0 &&
      form.lastName.trim().length > 0 &&
      form.userName.trim().length > 0 &&
      form.email.trim().length > 0 &&
      form.password.trim().length >= 6 &&
      form.userRole.trim().length > 0
    )
  }, [form])

  const isLoginValid = useMemo(() => {
    return (
      form.userName.trim().length > 0 &&
      form.password.trim().length >= 6
    )
  }, [form])

  async function onSubmit(event: FormEvent) {
    event.preventDefault()

    if (mode === 'signup') {
      if (!isSignupValid) {
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
          message: 'Account created successfully. You can now log in.',
        })

        setMode('login')
      } catch (error) {
        setStatus({ type: 'error', message: asReadableError(error) })
      }
    }

    if (mode === 'login') {
      if (!isLoginValid) {
        setStatus({ type: 'error', message: 'Enter username and password (min 6 chars).' })
        return
      }

      try {
        setStatus({ type: 'submitting' })

        // 🔹 TODO: replace with real login API
        console.log('Logging in with:', {
          userName: form.userName.trim(),
          password: form.password.trim(),
        })

        setStatus({
          type: 'success',
          message: 'Login successful.',
        })
      } catch (error) {
        setStatus({ type: 'error', message: asReadableError(error) })
      }
    }
  }

  return (
    <div className="authShell">
      <div className="authCard">
        <div className="authHeader">
          <h1 className="authTitle">
            {mode === 'signup' ? 'Create your account' : 'Welcome back'}
          </h1>
          <p className="authSubtitle">
            {mode === 'signup'
              ? 'Sign up to access the School system.'
              : 'Login using your username and password.'}
          </p>
        </div>

        <form className="authForm" onSubmit={onSubmit}>
          {mode === 'signup' && (
            <>
              <div className="authGrid">
                <label className="authField">
                  <span>First name</span>
                  <input
                    value={form.firstName}
                    onChange={(e) =>
                      setForm((s) => ({ ...s, firstName: e.target.value }))
                    }
                    required
                  />
                </label>

                <label className="authField">
                  <span>Last name</span>
                  <input
                    value={form.lastName}
                    onChange={(e) =>
                      setForm((s) => ({ ...s, lastName: e.target.value }))
                    }
                    required
                  />
                </label>
              </div>

              <label className="authField">
                <span>Email</span>
                <input
                  type="email"
                  value={form.email}
                  onChange={(e) =>
                    setForm((s) => ({ ...s, email: e.target.value }))
                  }
                  required
                />
              </label>

              <label className="authField">
                <span>Role</span>
                <select
                  value={form.userRole}
                  onChange={(e) =>
                    setForm((s) => ({ ...s, userRole: e.target.value as UserRole }))
                  }
                >
                  <option value="PRINCIPAL">Principal</option>
                  <option value="ADMINISTRATION">Administration</option>
                  <option value="TEACHER">Teacher</option>
                  <option value="STUDENT">Student</option>
                </select>
              </label>
            </>
          )}

          <label className="authField">
            <span>Username</span>
            <input
              value={form.userName}
              onChange={(e) =>
                setForm((s) => ({ ...s, userName: e.target.value }))
              }
              required
            />
          </label>

          <label className="authField">
            <span>Password</span>
            <input
              type="password"
              value={form.password}
              onChange={(e) =>
                setForm((s) => ({ ...s, password: e.target.value }))
              }
              minLength={6}
              required
            />
          </label>

          {status.type === 'error' && (
            <div className="authAlert authAlertError">{status.message}</div>
          )}
          {status.type === 'success' && (
            <div className="authAlert authAlertSuccess">{status.message}</div>
          )}

          <button className="authButton" type="submit">
            {status.type === 'submitting'
              ? 'Processing...'
              : mode === 'signup'
              ? 'Create account'
              : 'Login'}
          </button>

          <div className="authSwitch">
            {mode === 'signup' ? (
              <span onClick={() => { setMode('login'); setStatus({ type: 'idle' }) }}>
                Already have an account? Login
              </span>
            ) : (
              <span onClick={() => { setMode('signup'); setStatus({ type: 'idle' }) }}>
                Don't have an account? Sign up
              </span>
            )}
          </div>
        </form>
      </div>
    </div>
  )
}