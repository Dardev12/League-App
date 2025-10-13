//
//  ParameterDropDownSection.swift
//  iosApp
//
//  Created by Darren on 2025-10-12.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct ParameterExpandableSection<Content: View>: View {
    let title: String
    @Binding var expanded: Bool
    let content: () -> Content

    var body: some View {
        VStack(spacing: 0) {
            Button(action: {
                withAnimation {
                    expanded.toggle()
                }
            }) {
                HStack {
                    Text(title)
                        .font(.system(size: 18, weight: .bold))
                        .foregroundColor(.primary)

                    Spacer()

                    Image(systemName: "chevron.down")
                        .rotationEffect(.degrees(expanded ? 180 : 0))
                        .animation(.easeInOut(duration: 0.3), value: expanded)
                        .foregroundColor(.gray)
                }
                .padding()
                .background(Color(.systemBackground))
            }
            .buttonStyle(PlainButtonStyle())

            if expanded {
                VStack {
                    content()
                }
                .transition(.opacity.combined(with: .move(edge: .top)))
                .padding(.horizontal)
                .padding(.bottom, 8)
            }

            Divider()
        }
        .background(Color(.systemBackground))
        .cornerRadius(8)
    }
}
