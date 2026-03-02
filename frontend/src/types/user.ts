export type UserRole = 'PRINCIPAL' | 'ADMINISTRATION' | 'TEACHER' | 'STUDENT'

export type UserModel = {
  id?: string
  userName: string
  password: string
  email: string
  firstName: string
  lastName: string
  userRole: UserRole
}

export type CreateUserRequest = Omit<UserModel, 'id'>
