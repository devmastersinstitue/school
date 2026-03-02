import { http } from './http'
import type { CreateUserRequest, UserModel } from '../types/user'

export async function createUser(payload: CreateUserRequest): Promise<UserModel> {
  // Backend endpoint is currently implemented under LoginController
  // POST /api/login
  const response = await http.post<UserModel>('/api/login', payload)
  return response.data
}
