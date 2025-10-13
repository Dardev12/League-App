//
//  ParameterScreen.swift
//  iosApp
//
//  Created by Darren on 2025-10-12.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ParameterScreen: View {
    @State private var selection: String? = nil
    @State private var isSuccessRemoveUserToast: Bool = false
    @State private var isFailRemoveUserToast: Bool = false
    @State private var emailPasswordExpanded = false
    @State private var themeColorExpanded = false
    @State private var darkThemeEnabled = false
    @State private var accountManagementExpanded = false
    @ObservedObject var viewModel: ParameterViewModel
    
    init() {
        viewModel = ParameterViewModel()
    }
    
    var handleEraseAccount: () -> Void {
        return {
            AnalyticsManager.manager.logEvent(name: "Click_Remove_Account")
            
        }
    }
    
    var body: some View {
        ZStack{
            VStack{
                NavigationLink(destination: ProfilScreen(userID: viewModel.userId, yourProfil: true),tag: "Profil", selection: $selection){
                    EmptyView()
                }
                NavigationLink(destination: AuthMenuScreen(), tag: "AuthMenu", selection: $selection) {
                    EmptyView()
                }
                
                ScrollView(showsIndicators: false) {
                    VStack(spacing: 16) {
                        // Info Section
                        ParameterInfoSection()
                        
                        // Section Email & Password
                        ParameterExpandableSection(
                            title: "Section Email & Password",
                            expanded: $emailPasswordExpanded
                        ) {
                            VStack(alignment: .leading, spacing: 8) {
                                Text("Contenu de la section Email & Password")
                                    .padding(.bottom, 8)
                                // Ajoutez ici vos champs SwiftUI pour Email / Password
                                TextField("Email", text: .constant(""))
                                    .textFieldStyle(RoundedBorderTextFieldStyle())
                                SecureField("Mot de passe", text: .constant(""))
                                    .textFieldStyle(RoundedBorderTextFieldStyle())
                            }
                            .padding()
                        }

                        // Section Theme Color
                        ParameterExpandableSection(
                            title: "Theme Color",
                            expanded: $themeColorExpanded
                        ) {
                            HStack {
                                Toggle(isOn: $darkThemeEnabled) {
                                    HStack {
                                        Text("Dark theme -")
                                            .foregroundColor(.blue)
                                        Text("activate")
                                            .foregroundColor(.green)
                                    }
                                }
                            }
                            .padding()
                        }

                        // Section Gestion Compte
                        ParameterExpandableSection(
                            title: "Section Gestion Compte",
                            expanded: $accountManagementExpanded
                        ) {
                            VStack(spacing: 16) {
                                Text("Suppression du Compte")
                                
                                Button(action: {
                                    // Action de suppression
                                }) {
                                    Text("Supprimer Compte")
                                        .foregroundColor(.white)
                                        .frame(maxWidth: .infinity)
                                        .padding()
                                        .background(Color.red)
                                        .cornerRadius(12)
                                }
                                .frame(height: 56)
                            }
                            .padding()
                        }

                        Spacer().frame(height: 24)

                        CopyrightText()
                    }
                    .padding(.top, 70)
                    .padding(.horizontal, 16)
                }
            }.overlay(
                ZStack{
                    RoundedRectCorner(radius: 50, corners: [.bottomLeft, .bottomRight])
                        .frame(maxWidth: .infinity)
                        .frame(height: 106)
                        .foregroundColor(Color.background)
                        .shadow(color: Color.black.opacity(0.5), radius: 2, x: 0, y: 2)
                    ParameterTopBar(selection: $selection)
                }.frame(height: 106)
                    .edgesIgnoringSafeArea(.top),
                alignment: .top
            ).background(
                Color.background
                    .ignoresSafeArea()
            ).toast(
                isPresenting: $isSuccessRemoveUserToast,
                message: IosStringResources(id: SharedRes.strings().delete_account_success, args: []),
                icon: .success,
                backgroundColor: .green
            )
            .toast(
                isPresenting: $isFailRemoveUserToast,
                message: IosStringResources(id: SharedRes.strings().delete_account_failure, args: []),
                icon: .error,
                backgroundColor: .red
            ).navigationBarBackButtonHidden(true)
            if viewModel.isRemovePopUpOpen {
                BoxRemoveUserPopUp(
                    eventRemoveUserClick: handleEraseAccount,
                    eventCancelClick: {
                        viewModel.isRemovePopUpOpen = false
                    }
                )
            }
        }
    }
}
