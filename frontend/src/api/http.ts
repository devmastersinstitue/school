import axios from 'axios'

/**
 * Base HTTP client.
 *
 * - In dev, Vite proxies `/api/*` to the Spring backend (see `vite.config.ts`).
 * - In prod, keep the same-origin default by leaving baseURL empty.
 */
export const http = axios.create({
  baseURL: import.meta.env.VITE_API_BASE_URL ?? '',
  headers: {
    'Content-Type': 'application/json',
  },
})
